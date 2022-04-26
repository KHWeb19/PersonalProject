
<template>
<div class="p-3 mb-2 bg-light text-dark">
<div>
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
           <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;기획의도&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h3>
    </router-link>

      <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;애자일보드 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h3>
    </router-link>

          <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
      <h3>&nbsp;&nbsp;&nbsp;&emsp;로그인&nbsp;&nbsp;&nbsp;&nbsp;</h3>
    </router-link>

     <router-link style="text-decoration: none;" :to="{ name: 'VuetifyMemberJoinColumnTestPage' }">
      <h3>&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;회원가입&nbsp;</h3>
    </router-link>
    


     
      </v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item
        v-for="item in items"
        :key="item"
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

  
   
   <v-img
  lazy-src="https://picsum.photos/id/11/10/6"
  max-height="500"
  max-width="3000"
  src="https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F584%2F2021%2F08%2F28%2F0000015734_001_20210828101023352.jpg&type=sc960_832"
></v-img>

 <v-row>



    <v-col
      cols="6"
      sm="4"
    >
      <v-img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODEwMTFfNDAg%2FMDAxNTM5MjQzNjE0Mjc2.E9f6MHo6N_DyAZq8HCyAVdtUqPk_c3zI_yy3whF4eWEg.zr9BDHXx5mnBfAGdz_KKxXjebDZnqWx_fMbI9b5ueo4g.JPEG.gnsdl_-09%2F20181011163635.jpg&type=sc960_832">
        <div class="fill-height bottom-gradient"></div>
      </v-img>
    </v-col>

    <v-col
      cols="6"
      sm="4"
    >
      <v-img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODEwMTBfMjI5%2FMDAxNTM5MTczNTUxOTg3.MGtfKnJC0IjFFLN68qUgVbzV3o-1iNTVz2g2nfFT4wEg.wTgpBemaSs7AiIv_iRAMwnktvZZxjHOG9aO_IUDzHhMg.JPEG.gnsdl_-09%2F20181010211025.jpg&type=sc960_832">
        <div class="fill-height bottom-gradient"></div>
      </v-img>
    </v-col>

    <v-col
      cols="6"
      sm="4"
    >
     
      <v-img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODEwMDhfODYg%2FMDAxNTM4OTk4NDgxODgz.RpGphxHu-T06qio_-bPBpi9huczJPBVUs_B8XzMwd4Ag.5yNi3qRPnlsMP2W_k68jhXReZROIRqP4VfIstNzmbgQg.JPEG.gnsdl_-09%2F20181008203144.jpg&type=sc960_832">
        <div class="fill-height bottom-gradient"></div>
      </v-img>
    </v-col>
  </v-row>


   <v-footer
    color="primary lighten-1"
    padless
  >
    <v-row
      justify="center"
      no-gutters
    >
      <v-btn
        v-for="link in links"
        :key="link"
        color="white"
        text
        rounded
        class="my-2"
      >
        {{ link }}
      </v-btn>
      <v-col
        class="basil py-4 text-center green--text"
        cols="12"
      >
        {{ new Date().getFullYear() }} — <strong>project</strong>
      </v-col>
    </v-row>
  </v-footer>
</div>
</div>
</template>



<script>
  export default {
    data () {
      return {
        tab: null,
        items: [
          '기획의도','기획단계', '로그인', '회원가입',
        ],
       
      }
    },
  }
</script>

<style>
/* Helper classes */

h3{color: green;}

.basil {
  background-color: #FFFBE6 !important;
}
.basil--text {
  color: #356859 !important;
}
</style>
