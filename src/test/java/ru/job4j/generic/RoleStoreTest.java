package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Alex");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        Role result = store.findById("2");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.add(new Role("1", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Alex");
    }

    @Test
    void whenReplaceThenRoleNameIsMaxim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.replace("1", new Role("1", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Maxim");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.replace("10", new Role("10", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Alex");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Alex");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        boolean rsl = store.replace("1", new Role("1", "Maxim"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        boolean rsl = store.replace("10", new Role("10", "Maxim"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}