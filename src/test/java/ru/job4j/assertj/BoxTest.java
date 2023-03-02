package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEqualTo("Cube")
                .contains("her")
                .startsWithIgnoringCase("sph")
                .endsWith("ere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotNull()
                .endsWith("be")
                .contains("u");
    }

    @Test
    void whenNumberOfVerticesIs4() {
        Box box = new Box(4, 7);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isLessThan(5)
                .isGreaterThan(2)
                .isEqualTo(4);
    }

    @Test
    void whenNumberOfVerticesIsMin1() {
        Box box = new Box(-1, 2);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isOdd()
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void whenNumberOfVerticesIs8ThatTrue() {
        Box box = new Box(8, 9);
        boolean res = box.isExist();
        assertThat(res).isTrue()
                .isEqualTo(true);
    }

    @Test
    void whenNumberOfVerticesIsMin1ThatFalse() {
        Box box = new Box(-1, 6);
        boolean res = box.isExist();
        assertThat(res).isFalse()
                .isEqualTo(false);
    }

    @Test
    void whenNumberOfVerticesIs4GetArea28() {
        Box box = new Box(4, 4);
        double area = box.getArea();
        assertThat(area).
                isGreaterThan(1.0)
                .isCloseTo(27.71, offset( 0.1));
    }

    @Test
    void whenNumberOfVerticesIs0GetArea113() {
        Box box = new Box(0, 3);
        double area = box.getArea();
        assertThat(area).isNotZero()
                .isCloseTo(113.1, offset(0.1));
    }

}