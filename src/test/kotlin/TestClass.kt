import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

// class 는 java와 동일하다
class TestClass {

    /**
     * public method 는 fun 라고 선언한다.
     * TODO return type 이 없네?
     */
    @Test
    fun test() {
        // 문장의 끝에 세미콜론이 없어도 된다
        Assertions.assertFalse(false)
    }
}
