<template>
  <v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <div @click="home">로고 들어갈 자리</div>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-col> 
            <v-btn v-if="!isLogin" color="#003663" dense dark class="material-icons" style="font-size: 30px" :to="{name:'MemberLoginPage'}">
                person
            </v-btn>
            <v-btn v-if="isLogin" color="#003663" dense dark class="material-icons" style="font-size: 30px" :to="{name: 'MemberModifyPage'}" >
                person_add
            </v-btn>

        </v-col>
      </v-toolbar-items>
      <slot name="menubar"></slot>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>
        <v-list-item v-for="introduce in introduces" :key="introduce.name" router :to="introduce.route">
          <v-list-item-action>
            <v-icon left> {{ introduce.icon }} </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title> {{ introduce.text }} </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item v-for="recycle in recycles" :key="recycle.name" router :to="recycle.route">
          <v-list-item-action>
            <v-icon left> {{ recycle.icon }} </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title> {{ recycle.text }} </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item v-for="livingtip in livingtips" :key="livingtip.name" router :to="livingtip.route">
          <v-list-item-action>
            <v-icon left> {{ livingtip.icon }} </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title> {{ livingtip.text }} </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item v-for="share in shares" :key="share.name" router :to="share.route">
          <v-list-item-action>
            <v-icon left> {{ share.icon }} </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title> {{ share.text }} </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item v-for="donate in donates" :key="donate.name" router :to="donate.route">
          <v-list-item-action>
            <v-icon left> {{ donate.icon }} </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title> {{ donate.text }} </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item v-for="email in emails" :key="email.name" router :to="email.route">
          <v-list-item-action>
            <v-icon left> {{ email.icon }} </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title> {{ email.text }} </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

      </v-list>
    </v-navigation-drawer>

    <v-container>
      <v-content id="content">
        <router-view/>
      </v-content>
    </v-container>
s
  </v-app>
</template>

<script>
import router from '@/router'


export default {
  components: {

   },
    name: "LayOut",
  data () {
    return {
      drawer: false,
      left: false,
      introduces: [
        { icon: 'mdi-leaf-circle-outline', text: '프로젝트 소개', name: 'home', route: '/' }
      ],
      recycles: [
        { icon: 'mdi-recycle-variant', text: '분리수거 안내', name: 'home', route: '/' }
      ],
      livingtips: [
        { icon: 'mdi-note-edit-outline', text: '생활 정보 공유', name: 'home', route: '/' }
      ],
      shares: [
        { icon: 'mdi-store-marker-outline', text: '나눔 받는 가게', name: 'home', route: '/' }
      ],
      donates: [
        { icon: 'mdi-hand-heart-outline', text: '기부 정보', name: 'home', route: '/' }
      ],
      emails: [
        { icon: 'mdi-email-send-outline', text: '메일 제보', name: 'home', route: '/' }
      ],
}
  },
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    }
  }
}
</script>

<style scoped>
</style>