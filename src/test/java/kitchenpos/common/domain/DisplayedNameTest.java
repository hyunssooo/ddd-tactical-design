package kitchenpos.common.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("displayName은")
class DisplayedNameTest {

    @DisplayName("추가할 수 있다")
    @Nested
    class 추가할_수_있다 {

        @DisplayName("비어있다면 추가할 수 없다.")
        @ParameterizedTest(name = "{0} 인 경우")
        @NullAndEmptySource
        void 비어있다면_추가할_수_없다(String value) {
            assertThatIllegalArgumentException()
                .isThrownBy(() -> new DisplayedName(value));
        }

        @DisplayName("비어있지 않다면 추가할 수 있다.")
        @Test
        void 비어있지_않다면_추가할_수_있다() {
            assertDoesNotThrow(() -> new DisplayedName("테스트"));
        }
    }
}
