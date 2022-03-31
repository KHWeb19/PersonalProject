<template>
  <v-app>
    <core-app-bar />
    <core-view />
    <v-main>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'Home',
  components: {
      CoreAppBar: () => import('@/components/core/AppBar'),
      CoreView: () => import('@/components/core/View'),
    },
};
</script>