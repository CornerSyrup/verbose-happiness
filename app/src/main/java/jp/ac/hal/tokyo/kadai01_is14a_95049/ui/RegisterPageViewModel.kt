package jp.ac.hal.tokyo.kadai01_is14a_95049.ui

import android.view.View
import android.widget.CompoundButton
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.microsoft.fluentui.datetimepicker.DateTimePickerDialog
import jp.ac.hal.tokyo.kadai01_is14a_95049.BR
import jp.ac.hal.tokyo.kadai01_is14a_95049.R
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisterItem
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisteredItemDb
import org.threeten.bp.Duration
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime

class RegisterPageViewModel(val model: RegisterItem, private val mode: RegisterPageMode) :
    BaseObservable() {
    init {
        this.model.apply {
            ZonedDateTime.now().let {
                year = it.year
                month = it.monthValue
                day = it.dayOfMonth
            }

            title = ""
            flow = false
            amount = 0f
        }
    }

    @get:Bindable
    val date: String
        get() = "${model.year} / ${model.month} / ${model.day}"

    @get:Bindable
    val commitText: Int
        get() = when (mode) {
            RegisterPageMode.Create -> R.string.register_btn_reg
            RegisterPageMode.Copy -> R.string.register_btn_dup
            RegisterPageMode.Edit -> R.string.register_btn_edt
        }

    @get:Bindable
    val commitCommand: View.OnClickListener
        get() = when (mode) {
            RegisterPageMode.Create -> View.OnClickListener { view -> register(view) }
            RegisterPageMode.Copy -> View.OnClickListener { view -> clone(view) }
            RegisterPageMode.Edit -> View.OnClickListener { view -> update(view) }
        }

    private val modelZonedDate: ZonedDateTime
        get() = ZonedDateTime.of(
            model.year, model.month, model.day,
            0, 0, 0, 0,
            ZoneId.systemDefault()
        )

    fun register(view: View) {
        RegisteredItemDb.getRegisterItemDb()?.registerItemDao()?.insert(model)
        view.findNavController().navigate(RegisterPageDirections.actionRegisterPageToDetailPage())
    }

    fun update(view: View) {
        RegisteredItemDb.getRegisterItemDb()?.registerItemDao()?.update(model)
        view.findNavController().navigate(RegisterPageDirections.actionRegisterPageToDetailPage())
    }

    fun clone(view: View) {
        RegisteredItemDb.getRegisterItemDb()?.registerItemDao()?.insert(model.copy(id = 0))
        view.findNavController().navigate(RegisterPageDirections.actionRegisterPageToDetailPage())

    }

    fun cancel(view: View) {
        view.findNavController().navigate(RegisterPageDirections.actionRegisterToHome())
    }

    /**
     * EditText event handler for date field. Will pop a date picker.
     */
    fun changeDate(view: View) {
        DateTimePickerDialog(
            view.context,
            DateTimePickerDialog.Mode.DATE,
            DateTimePickerDialog.DateRangeMode.NONE,
            modelZonedDate,
            Duration.ZERO
        ).apply {
            onDateTimePickedListener = object : DateTimePickerDialog.OnDateTimePickedListener {
                override fun onDateTimePicked(dateTime: ZonedDateTime, duration: Duration) {
                    model.year = dateTime.year
                    model.month = dateTime.monthValue
                    model.day = dateTime.dayOfMonth

                    notifyPropertyChanged(BR.date)
                }
            }
        }.show()
    }

    /**
     * RadioButton event handler. Manage state for record flow.
     */
    fun isIncomeChanged(view: CompoundButton, checked: Boolean) {
        if (this.model.flow == checked) {
            this.model.flow = checked
        }
    }

    /**
     * RadioButton event handler. Manage state for record flow.
     * @param checked If the record is an expense record.
     */
    fun isExpenseChanged(view: CompoundButton, checked: Boolean) {
        if (this.model.flow xor checked) {
            this.model.flow = !checked
        }
    }
}