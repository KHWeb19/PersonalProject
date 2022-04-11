<template>
  <v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link style="text-decoration: none;"  :to="{ name: 'JpaBoardListPage' }">
     <h3>스마트 노트</h3>
    </router-link>
        
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
           
          </v-list-item-action>
          <v-list-item-action>
             <pre>
            <h1>생활편의</h1>
             </pre>
            <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage1' }">
              <h4>계좌번호관리</h4> 
             </router-link>
             <p>
             </p>
             
             <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage2' }">
              <h4>장보기 목록</h4> 
             </router-link>

               <p>
             </p>
           
           
              <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage3' }">
              <h4>생일 관리</h4> 
             </router-link>

               <p>
             </p>
           <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage4' }">
              <h4>사이트 아이디 관리</h4> 
             </router-link>
               <p>
             </p>
            <pre>
              <h1>일반메모</h1>
            </pre>

               <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage' }">
              <h4>텍스트 메모</h4> 
             </router-link>
          </v-list-item-action>          
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>
    <v-footer app color="blue" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
  </v-app>
</template>

<script>
import router from '@/router'
export default {
  name: "Layout.vue",
  data () {
    return {
      drawer: false,
      left: false
    }
  },
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/daumNewsCrawler') ? router.push('/') : router.go(0)
    }
  }
}
</script>

<style scoped>
h3{color: white;}
</style>

