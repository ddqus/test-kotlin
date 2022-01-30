import org.assertj.core.api.Assertions.assertThat
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

    /**
     * TODO 메소드명 prefix에 test가 없어도 되나?
     * TODO internal이 private 인가?
     * 경고: Use of getter method instead of property access syntax
     */
    @Test
    internal fun assertj() {
        assertThat(true).isTrue()
    }

    @Test
    internal fun usePropertyAccessSyntax_notGetterMethod() {
        assertThat(true).isTrue
    }

    /**
     * backtick을 이용하면 string을 메서드명으로 사용할 수 있다
     */
    @Test
    internal fun `test backtick identifiers and 한글`() {
        assertThat(false).isFalse
    }
}
