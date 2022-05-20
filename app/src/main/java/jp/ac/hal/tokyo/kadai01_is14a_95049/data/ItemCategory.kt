package jp.ac.hal.tokyo.kadai01_is14a_95049.data

import androidx.annotation.StringRes
import jp.ac.hal.tokyo.kadai01_is14a_95049.R

enum class ItemCategory(@StringRes val res: Int) {
    // その他
    Others(R.string.item_category_others),

    // 飲食
    Food(R.string.item_category_food),

    // 水道光熱
    PublicBusiness(R.string.item_category_public),

    // 住宅
    RealEstate(R.string.item_category_estate),

    // 通信
    Telecom(R.string.item_category_telecom),

    // 車両
    Car(R.string.item_category_car),

    // 学費
    School(R.string.item_category_school),

    // 税金
    Tax(R.string.item_category_tax),

    // 交通
    Transportation(R.string.item_category_transport),

    // 購読・定期
    Subscriptions(R.string.item_category_subscribe),
}