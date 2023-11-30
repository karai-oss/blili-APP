package com.github.bliblipanel.model.domain


data class FenWorkModel(
    val code: Int,
    val data: WorkData,
    val message: String,
    val ttl: Int
)

data class WorkData(
    val list: List,
    val page: Page
)

data class List(
    val tlist: Tlist,
    val vlist: kotlin.collections.List<VideoItem> = listOf<VideoItem>()
)

data class Page(
    val count: Int,
    val pn: Int,
    val ps: Int
)

data class Tlist(
    val `129`: X129,
    val `160`: X129,
    val `3`: X129
)
data class VideoItem(
    val aid: Int,
    val attribute: Int,
    val author: String,
    val bvid: String,
    val comment: Int,
    val copyright: String,
    val created: Int,
    val description: String,
    val enable_vt: Int,
    val hide_click: Boolean,
    val is_avoided: Int,
    val is_charging_arc: Boolean,
    val is_live_playback: Int,
    val is_pay: Int,
    val is_steins_gate: Int,
    val is_union_video: Int,
    val length: String,
    val meta: Any,
    val mid: Int,
    val pic: String,
    val play: Int,
    val playback_position: Int,
    val review: Int,
    val subtitle: String,
    val title: String,
    val typeid: Int,
    val video_review: Int,
    val vt: Int,
    val vt_display: String
)


data class X129(
    val count: Int,
    val name: String,
    val tid: Int
)