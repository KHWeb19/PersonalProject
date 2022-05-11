<template >

<div class="p-3 mb-2 bg-light text-dark">


<div>
  

<body>
  <v-card color="basil">

     <div class=" big ">
   &emsp;&emsp; <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
    </div>

       <v-navigation-drawer
      v-model="drawer"
      absolute
      bottom
      temporary
    >
      <v-list
        nav
        dense
      >
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>

          <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage' }">  
      <h5>텍스트 메모</h5>
    </router-link>

          </v-list-item>

          <v-list-item>

        <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage1' }">
      <h5>계좌번호 메모</h5>
    </router-link>

          </v-list-item>

          <v-list-item>

           <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage2' }">
      <h5>장보기 메모</h5>
    </router-link>

          </v-list-item>

          <v-list-item>

          <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage4' }">
      <h5>사이트아이디 메모</h5>
    </router-link>
    
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <v-card-title class="text-center justify-center py-6">
      <h1 class="font-weight-bold text-h2 basil--text"  >
      Note
      </h1>
    </v-card-title>

    <v-tabs
      v-model="tab"
      background-color="transparent"
      color="basil"
      grow
    >
   
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item
        v-for="item in items"
        :key="item"
         color="basil"
      >
        <v-card
          color="basil"
          flat
        >
          <v-card-text>{{ text }}</v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>

    

  </v-card>




    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>

<div align="center">
    <div id="board">
       <h1 class="font-weight-bold text-h3 basil--text"  >
       생일 메모
      </h1>
      
       
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  <v-btn
      class="mx-2"
      fab
      dark
      color="green"
       @click="pageLink"
    >
      <v-icon dark>
        mdi-plus
      </v-icon>
    </v-btn>
     
        <br>        
        <jpa-board-list-3 :jpaBoards3="jpaBoards3"/>
    </div>
</div>






      <v-footer app color="#FFFBE6" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
</body> 
</div>
</div>
</template>


<script>

import JpaBoardList3 from '@/components/jpaBoard3/JpaBoardList3.vue'
import { mapState, mapActions } from 'vuex'


export default {
    name: 'JpaBoardListPage3',

 data () {
    return {
      drawer: false,
      left: false,
   
        
      }
    },

    components: {
      JpaBoardList3,
      
    },
    computed: {
        ...mapState(['jpaBoards3'])
    },
    mounted () {
        this.fetchJpaBoardList3()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList3']),
    
       pageLink() {
            this.$router.push({ name: 'JpaBoardRegisterPage3' })



        }
        
    }
        
    }
    



</script>


<style scoped>
h3{color: green;}
h1{color: green;}

.basil {
  background-color: #FFFBE6 !important;
}
.basil--text {
  color: #356859 !important;
}

</style>