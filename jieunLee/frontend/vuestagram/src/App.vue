<template>
  <v-app>
    <v-app-bar app>
      <div class="d-flex align-center">
        <router-link style="text-decoration: none;" :to="{name: 'Home'}">
          <div class="black--text">Vuestagram</div>
        </router-link>
      </div>

      <v-spacer></v-spacer>

      <router-link style="text-decoration: none;" :to="{name: 'Home'}">
        <v-icon>mdi-home</v-icon>
      </router-link>
      <router-link style="text-decoration: none;" :to="{name: 'MyPage'}">
        &nbsp;MyPage&nbsp;
      </router-link>
      <router-link style="text-decoration: none;" :to="{name: 'AccountsEditPage'}">
        &nbsp;AccountsEditPage&nbsp;
      </router-link>
      <v-btn>로그아웃</v-btn>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>

<style scoped>

</style>