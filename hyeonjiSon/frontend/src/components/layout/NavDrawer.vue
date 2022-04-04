<template>
  <v-navigation-drawer>
    <v-list-item-action>
        <v-icon left>
            mdi-recycling
        </v-icon>
    </v-list-item-action>
    <v-list-item-content>
        <v-list-item-title>
          <div @click="home">  프로젝트 소개 </div>
        </v-list-item-title>
    </v-list-item-content>

    <v-list-item-action>
        <v-icon left>
            mdi-delete
        </v-icon>
    </v-list-item-action>
    <v-list-item-content>
        <v-list-item-title>
           <div @click="home">  분리수거 안내 </div>
        </v-list-item-title>
    </v-list-item-content>

    <v-list-item-action>
        <v-icon left>
            mdi-tips-and-updates
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">생활 정보 공유</v-list-item-title>
    </v-list-item-action>

    <v-list-item-action>
        <v-icon left>
            mdi-store
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">아이스팩 나눔 정보</v-list-item-title>
    </v-list-item-action>

        <v-list-item-action>
        <v-icon left>
            mdi-volunteer-activism
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">기부 정보</v-list-item-title>
    </v-list-item-action>

        <v-list-item-action>
        <v-icon left>
            mdi-email
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">제보</v-list-item-title>
    </v-list-item-action>
  </v-navigation-drawer>
</template>

<script>

import router from '@/router'

export default {
  name: "NavDrawer",
  data () {
    return {
      drawer: false
    }
  },
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    }
  }
}

</script>

<style scoped>

</style>