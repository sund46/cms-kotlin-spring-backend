package kdh.cms.domain.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

/**
 * 베이스 엔티티 클래스
 * 엔티티 클래스가 기본적으로 상속받는 클래스
 */
@MappedSuperclass // 엔티티 별로 공통 필드가 존재하는 경우 불 필요한 주복 코드를 제거하기 위해 사용.
@EntityListeners(AuditingEntityListener::class) // Spring Data JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능
class BaseEntity: Serializable{

    /**
     * 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreatedDate
    @Column(updatable = false)
    var createdAt: LocalDateTime? = LocalDateTime.now()

    @Column(updatable = false)
    var updatedAt: LocalDateTime? = LocalDateTime.now()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , createdAt = $createdAt , updatedAt = $updatedAt )"
    }
}