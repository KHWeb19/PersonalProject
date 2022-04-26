<template >

<div class="p-3 mb-2 bg-light text-dark">


<div>
  

<body>
  <v-card color="basil">
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
      <v-tab
      >  
           <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage' }">  
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;텍스트 메모&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h3>
    </router-link>

      <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage1' }">
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;계좌번호 메모 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h3>
    </router-link>

          <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage2' }">
      <h3>&nbsp;&nbsp;&nbsp;&emsp;장보기 메모&nbsp;&nbsp;&nbsp;&nbsp;</h3>
    </router-link>

     <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage3' }">
      <h3>&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;생일 메모&nbsp;</h3>
    </router-link>
    



      </v-tab>
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
       사이트 아이디 메모
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
        <jpa-board-list-4 :jpaBoards4="jpaBoards4"/>
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

import JpaBoardList4 from '@/components/jpaBoard4/JpaBoardList4.vue'
import { mapState, mapActions } from 'vuex'


export default {
    name: 'JpaBoardListPage4',

 data () {
    return {
      drawer: false,
      left: false,
   
        
      }
    },

    components: {
      JpaBoardList4,
      
    },
    computed: {
        ...mapState(['jpaBoards4'])
    },
    mounted () {
        this.fetchJpaBoardList4()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList4']),
    
       pageLink() {
            this.$router.push({ name: 'JpaBoardRegisterPage4' })



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