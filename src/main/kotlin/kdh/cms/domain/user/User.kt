package kdh.cms.domain.user

import kdh.cms.domain.common.BaseEntity
import kdh.cms.domain.post.Post
import javax.persistence.Entity
import javax.persistence.Table

/**
 * 사용자 도메인
 */
@Entity
@Table
class User(
    var userId: String? = null,
    var userPassword: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
): BaseEntity(){
    constructor(user: User): this(){
        this.update(user)
    }

    fun update(updateUser: User){
        updateUser.userId.let { this.userId = it }
        updateUser.userPassword.let { this.userPassword = it }
        updateUser.email.let { this.email = it }
        updateUser.phoneNumber.let { this.phoneNumber = it }
    }

    override fun toString(): String {
        return "Post(" +
                "id = $id" +
                ", userId = $userId" +
                ", userPassword = $userPassword" +
                ", email = $email" +
                ", phoneNumber = $phoneNumber" +
                ", createdAt = $createdAt" +
                ", updatedAt = $updatedAt" +
                ")"
    }
}