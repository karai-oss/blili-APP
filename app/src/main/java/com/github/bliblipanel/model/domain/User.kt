package com.github.bliblipanel.model.domain

import kotlin.collections.List


data class UserInfoWrapperDoMain(
    val code: Int,
    val `data`: Data,
    val message: String,
    val ttl: Int
)


/*用户信息相关*/
data class Data(
    val birthday: String,
    val certificate_show: Boolean,
    val coins: Double,
    val contract: Contract,
    val elec: Elec,
    val face: String,
    val face_nft: Int,
    val face_nft_type: Int,
    val fans_badge: Boolean,
    val fans_medal: FansMedal,
    val gaia_data: String,
    val gaia_res_type: Int,
    val is_followed: Boolean,
    val is_risk: Boolean,
    val is_senior_member: Int,
    val jointime: Int,
    val level: Int,
    val live_room: LiveRoom,
    val mcn_info: String,
    val mid: Int,
    val moral: Int,
    val name: String,
    val nameplate: Nameplate,
    val official: Official,
    val pendant: Pendant,
    val profession: Profession,
    val rank: Int,
    val school: School,
    val series: Series,
    val sex: String,
    val sign: String,
    val silence: Int,
    val sys_notice: SysNotice,
    val tags: String,
    val theme: Theme,
    val top_photo: String,
    val user_honour_info: UserHonourInfo,
    val vip: Vip
)

data class Contract(
    val is_display: Boolean,
    val is_follow_display: Boolean
)

data class Elec(
    val show_info: ShowInfo
)

data class FansMedal(
    val medal: String,
    val show: Boolean,
    val wear: Boolean
)

data class LiveRoom(
    val broadcast_type: Int,
    val cover: String,
    val liveStatus: Int,
    val roomStatus: Int,
    val roomid: Int,
    val roundStatus: Int,
    val title: String,
    val url: String,
    val watched_show: WatchedShow
)

data class Nameplate(
    val condition: String,
    val image: String,
    val image_small: String,
    val level: String,
    val name: String,
    val nid: Int
)

data class Official(
    val desc: String,
    val role: Int,
    val title: String,
    val type: Int
)

data class Pendant(
    val expire: Int,
    val image: String,
    val image_enhance: String,
    val image_enhance_frame: String,
    val n_pid: Int,
    val name: String,
    val pid: Int
)

data class Profession(
    val department: String,
    val is_show: Int,
    val name: String,
    val title: String
)

data class School(
    val name: String
)

data class Series(
    val show_upgrade_window: Boolean,
    val user_upgrade_status: Int
)

class SysNotice

class Theme

data class UserHonourInfo(
    val colour: String,
    val is_latest_100honour: Int,
    val mid: Int,
    val tags: kotlin.collections.List<Any>
)

data class Vip(
    val avatar_subscript: Int,
    val avatar_subscript_url: String,
    val due_date: Int,
    val label: Label,
    val nickname_color: String,
    val role: Int,
    val status: Int,
    val theme_type: Int,
    val tv_due_date: Int,
    val tv_vip_pay_type: Int,
    val tv_vip_status: Int,
    val type: Int,
    val vip_pay_type: Int
)

data class ShowInfo(
    val icon: String,
    val jump_url: String,
    val show: Boolean,
    val state: Int,
    val title: String
)

data class WatchedShow(
    val icon: String,
    val icon_location: String,
    val icon_web: String,
    val num: Int,
    val switch: Boolean,
    val text_large: String,
    val text_small: String
)

data class Label(
    val bg_color: String,
    val bg_style: Int,
    val border_color: String,
    val img_label_uri_hans: String,
    val img_label_uri_hans_static: String,
    val img_label_uri_hant: String,
    val img_label_uri_hant_static: String,
    val label_theme: String,
    val path: String,
    val text: String,
    val text_color: String,
    val use_img_label: Boolean
)


/**
 * 粉丝相关
 */

data class UserFenModel(
    val code: Int,
    val data: UserFenData,
    val message: String,
    val ttl: Int
)

data class UserFenData(
    val list: List<UserListItem>,
    val total: Int
)

data class UserListItem (
    val attribute: Int,
    val contract_info: ContractInfo,
    val face: String,
    val face_nft: Int,
    val mid: Long,
    val mtime: Int,
    val nft_icon: String,
    val official_verify: OfficialVerify,
    val rec_reason: String,
    val sign: String,
    val special: Int,
    val tag: Any,
    val track_id: String,
    val uname: String,
    val vip: UserListItemVip
)

class ContractInfo

data class OfficialVerify(
    val desc: String,
    val type: Int
)

data class UserListItemVip(
    val accessStatus: Int,
    val avatar_subscript: Int,
    val avatar_subscript_url: String,
    val dueRemark: String,
    val label: UserListItemLabel,
    val nickname_color: String,
    val themeType: Int,
    val vipDueDate: Long,
    val vipStatus: Int,
    val vipStatusWarn: String,
    val vipType: Int
)

data class UserListItemLabel(
    val bg_color: String,
    val bg_style: Int,
    val border_color: String,
    val label_theme: String,
    val path: String,
    val text: String,
    val text_color: String
)