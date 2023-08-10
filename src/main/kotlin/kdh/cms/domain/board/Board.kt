package kdh.cms.domain.board

import kdh.cms.domain.common.BaseEntity
import kdh.cms.domain.post.Post
import javax.persistence.Entity
import javax.persistence.Table

/**
 * 게시물 도메인
 */
@Entity
@Table
class Board(
    var postId: Long? = null,
    var title: String? = null,
    var content: String? = null,
): BaseEntity(){
    constructor(board: Board): this(){
        this.update(board)
    }

    fun update(update: Board){
        update.postId?.let { this.postId = it}
        update.title?.let { this.title = it}
        update.content?.let { this.content = it}
    }

    override fun toString(): String {
        return "Board(" +
                "id = $id" +
                ", postId = $postId" +
                ", title = $title" +
                ", content = $content" +
                ", createdAt = $createdAt" +
                ", updatedAt = $updatedAt" +
                ")"
    }
}