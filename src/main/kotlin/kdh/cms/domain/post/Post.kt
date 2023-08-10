package kdh.cms.domain.post

import kdh.cms.domain.common.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

/**
 * 게시판 도메인
 */
@Entity
@Table
class Post(
    var name: String? = null,
    var createdUser: String? = null,
    var updatedUser: String? = null,
): BaseEntity(){
    constructor(post: Post) : this(){
        this.update(post)
    }

    fun update(updatePost: Post){
        updatePost.name.let { this.name = it }
    }

    override fun toString(): String {
        return "Post(" +
                "id = $id" +
                ", name = $name" +
                ", createdUser = $createdUser" +
                ", createdAt = $createdAt" +
                ", updatedUser = $updatedUser" +
                ", updatedAt = $updatedAt" +
                ")"
    }
}