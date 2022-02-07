package com.example.webview2.data.mapper

import com.example.webview2.data.database.LinkContainerDbModel
import com.example.webview2.data.network.api.model.LinkContainerDto
import com.example.webview2.domain.LinkContainer

class WebViewMapper {

    fun mapDtoToDbModel(dto: LinkContainerDto) = LinkContainerDbModel(
            key = dto.key,
            link = dto.link,
            home = dto.home
        )

    fun mapDbModelToEntity(dbModel: LinkContainerDbModel) = LinkContainer(
        link = dbModel.link,
        home = dbModel.home
    )

}