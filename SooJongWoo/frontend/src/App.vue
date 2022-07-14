<template>
  <v-app>
    <menu-bar
      v-if="
        $route.name !== 'MainPage' &&
        $route.name !== 'Home' &&
        $route.name !== 'BookingListPage' &&
        $route.name !== 'BookingReadPage' &&
        $route.name !== 'MemberListPage' &&
        $route.name !== 'MemberModifyPage' &&
        $route.name !== 'MemberReadPage' &&
        $route.name !== 'MyReservation' &&
        $route.name !== 'ReservationReadPage' &&
        $route.name !== 'UserList' &&
        $route.name !== 'UserModifyPage' &&
        $route.name !== 'UserReadPage'
      "
    />
    <v-main>
      <router-view />
    </v-main>
    <footer-view />
  </v-app>
</template>

<script>
import MenuBar from "@/views/MenuBar.vue";
import FooterView from "@/views/FooterView.vue";

export default {
  name: "App",
  components: {
    MenuBar,
    FooterView,
  },
};
</script>

<style Footere>
</style>