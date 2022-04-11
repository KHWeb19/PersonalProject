<template>


<v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link style="text-decoration: none;"  :to="{ name: 'JpaBoardListPage' }">
     <h3>사이트아이디 메모</h3>
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

<div align="center">
    <div id="board">
        <h1>사이트 아이디 관리</h1>
        <router-link :to="{ name: 'JpaBoardRegisterPage4' }">
            게시물 작성
        </router-link>
        <jpa-board-list-4 :jpaBoards4="jpaBoards4"/>
    </div>
</div>




      <v-footer app color="blue" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
</v-app>
</template>

<script>
import JpaBoardList4 from '@/components/jpaBoard4/JpaBoardList4.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'JpaBoardListPage4',

      data () {
    return {
      drawer: false,
      left: false
    }
  },
  
    components: {
      JpaBoardList4
    },
    computed: {
        ...mapState(['jpaBoards4'])
    },
    mounted () {
        this.fetchJpaBoardList4()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList4'])
    }
}
</script>


<style scoped>
h3{color: white;}
</style>
