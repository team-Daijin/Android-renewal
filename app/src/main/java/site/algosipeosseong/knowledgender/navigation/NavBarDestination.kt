package site.algosipeosseong.knowledgender.navigation


import site.algosipeosseong.common.CENTER
import site.algosipeosseong.common.HOME
import site.algosipeosseong.common.MY
import site.algosipeosseong.designsystem.icon.KnowledgenderIcons.Center
import site.algosipeosseong.designsystem.icon.KnowledgenderIcons.Home
import site.algosipeosseong.designsystem.icon.KnowledgenderIcons.My

enum class TopLevelDestination(
    val route: String,
    val icon: Int,
    val text: String
) {
    CENTER(
        route = site.algosipeosseong.common.CENTER,
        icon = Center,
        text = "상담센터",
    ),
    HOME(
        route = site.algosipeosseong.common.HOME,
        icon = Home,
        text = "홈"
    ),
    MY(
        route = site.algosipeosseong.common.MY,
        icon = My,
        text = "마이"
    ),
}