package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUNKNOWN() {
        Box box = new Box(1, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void getVerticalsTrue() {
        Box box = new Box(4, 12);
        int vetx = box.getNumberOfVertices();
        assertThat(vetx).isEqualTo(4);
    }

    @Test
    void getVerticalsFalse() {
        Box box = new Box(3, 12);
        int vetx = box.getNumberOfVertices();
        assertThat(vetx).isEqualTo(-1);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(4, 33);
        boolean ex = box.isExist();
        assertThat(ex).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(3, 33);
        boolean ex = box.isExist();
        assertThat(ex).isFalse();
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(16 * Math.PI, withPrecision(0.01D));
    }

    @Test
    void getAreaCube() {
        Box box = new Box(8, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(6 * 4);
    }

    @Test
    void getAreaUnknownObject() {
        Box box = new Box(3, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(0);
    }
}