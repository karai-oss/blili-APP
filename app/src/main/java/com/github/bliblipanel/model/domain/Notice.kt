package com.github.bliblipanel.model.domain

import kotlin.collections.List


data class ReplyNoticeData(
    val code: Int,
    val data: ReplyData,
    val message: String,
    val ttl: Int
)

data class ReplyData(
    val cursor: Cursor,
    val items: kotlin.collections.List<ReplyItem>,
    val last_view_at: Int
)

data class Cursor(
    val id: Long,
    val is_end: Boolean,
    val time: Int
)

data class ReplyItem(
    val counts: Int,
    val id: Long,
    val is_multi: Int,
    val item: ItemX,
    val reply_time: Int,
    val user: User
)

data class ItemX(
    val at_details: kotlin.collections.List<AtDetail>,
    val business: String,
    val business_id: Int,
    val danmu: Any,
    val desc: String,
    val detail_title: String,
    val hide_like_button: Boolean,
    val hide_reply_button: Boolean,
    val image: String,
    val like_state: Int,
    val message: String,
    val native_uri: String,
    val root_id: Long,
    val root_reply_content: String,
    val source_content: String,
    val source_id: Long,
    val subject_id: Int,
    val target_id: Long,
    val target_reply_content: String,
    val title: String,
    val topic_details: List<Any>,
    val type: String,
    val uri: String
)

data class User(
    val avatar: String,
    val fans: Int,
    val follow: Boolean,
    val mid: Long,
    val mid_link: String,
    val nickname: String
)

data class AtDetail(
    val avatar: String,
    val fans: Int,
    val follow: Boolean,
    val mid: Int,
    val mid_link: String,
    val nickname: String
)