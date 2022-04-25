<template>
  <v-app>
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

<style>
@font-face {
  font-family: 'ACCchildrenheartOTF-Regular';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2112-2@1.0/ACCchildrenheartOTF-Regular.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
*{
  font-family: 'ACCchildrenheartOTF-Regular';
}
</style>
