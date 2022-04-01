<template>
  <div>
    <v-list-item-action>
        <v-icon>
            mdi-compost
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">프로젝트 소개</v-list-item-title>
    </v-list-item-action>
<br>
    <v-list-item-action>
        <v-icon>
            mdi-delete
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">분리수거 도움 안내</v-list-item-title>
    </v-list-item-action>
<br>
    <v-list-item-action>
        <v-icon>
            mdi-tips-and-updates
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">생활 정보 공유</v-list-item-title>
    </v-list-item-action>
<br>
    <v-list-item-action>
        <v-icon>
            mdi-store
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">아이스팩 나눔 정보</v-list-item-title>
    </v-list-item-action>
<br>
        <v-list-item-action>
        <v-icon>
            mdi-volunteer-activism
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">기부 정보</v-list-item-title>
    </v-list-item-action>
<br>
        <v-list-item-action>
        <v-icon>
            mdi-email
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">제보</v-list-item-title>
    </v-list-item-action>

  </div>
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
    category () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    }
  }
}

</script>

<style scoped>

</style>