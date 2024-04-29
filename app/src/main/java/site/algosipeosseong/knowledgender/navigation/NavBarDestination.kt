package site.algosipeosseong.knowledgender.navigation

import site.algosipeosseong.designsystem.icon.KnowledgenderIcons.Center
import site.algosipeosseong.designsystem.icon.KnowledgenderIcons.Home
import site.algosipeosseong.designsystem.icon.KnowledgenderIcons.My

enum class TopLevelDestination(
    val icon: Int,
    val text: String
) {
    HOME(
        icon = Home,
        text = "홈"
    ),
    CENTER(
        icon = Center,
        text = "상담센터",
    ),
    MY(
        icon = My,
        text = "마이"
    ),
}