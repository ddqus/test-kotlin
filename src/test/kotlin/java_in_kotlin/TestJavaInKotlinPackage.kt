package java_in_kotlin

import example.JavaInterface
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestJavaInKotlinPackage {
    @Test
    internal fun `test java in java package`() {
        val impl = JavaInJavaPackage()
        assertThat(impl.call()).isEqualTo("java in java package")
    }

//    class JavaInKotlinPackage : JavaInKotlin {
//        override fun name(): String {
//            return "java in kotlin package"
//        }
//    }

    class JavaInJavaPackage : JavaInterface {
        override fun call(): String {
            return "java in java package"
        }

    }
}