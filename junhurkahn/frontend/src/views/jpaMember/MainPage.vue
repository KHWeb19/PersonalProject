
<template>
<div class="p-3 mb-2 bg-light text-dark">
<div>
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

          <router-link style="text-decoration: none;" :to="{ name: 'IntentionPlan' }">
      <h5>기획의도</h5>
    </router-link>

          </v-list-item>

          <v-list-item>

         <router-link style="text-decoration: none;" :to="{ name: 'PlanningStage' }">
      <h5>기획단계</h5>
    </router-link>

          </v-list-item>

          <v-list-item>

                <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
      <h5>로그인</h5>
    </router-link>

          </v-list-item>

          <v-list-item>

            <router-link style="text-decoration: none;" :to="{ name: 'VuetifyMemberJoinColumnTestPage' }">
      <h5>회원가입</h5>
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
  </v-card>


<v-row>
    

    <v-col
      cols="6"
      sm="4"
    >
<br>
<v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA2MjdfMzQg%2FMDAxNTkzMTg5NjIyNDQy.ldGF1qBIspFCjVNWfMs72_Xg3JUnAzxn_Ybvji4szVMg.L727JWrhlsafuVvQ-Lyo0kn_cPAlknZNzUN5eEOO8kQg.JPEG.hjjun1011%2FWoman_drinking_coffee_and_writing_a_diary_note_-_Woman_drinking_coffee_and_m.jpg&type=sc960_832"
      height="200px"
    ></v-img>
      <br>
       <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage' }">  
      <h5> &emsp;&emsp;텍스트 메모</h5>
    </router-link>

   

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
        텍스트와 사진을 올리는 공간
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
    </v-col>

  



    <v-col
      cols="6"
      sm="4"
    >
<br>
<v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20130329_73%2Fchangajooay_1364539128105Qfh9j_JPEG%2F2013-03-29_15%253B05%253B04.JPG&type=sc960_832"
      height="200px"
    ></v-img>

    <br>
       <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage1' }">  
     <h5> &emsp;&emsp;계좌번호 메모</h5>
    </router-link>

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
          계좌번호와 사진을 올리는 공간
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
    </v-col>


  
    <v-col
      cols="6"
      sm="4"
    >
<br>
<v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fsale-shopping-bag-picture-id124117827&type=sc960_832"
      height="200px"
    ></v-img>

    <br>
       <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage2' }">  
     <h5> &emsp;&emsp;장보기 메모</h5>
    </router-link>

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
         장보기와 사진을 올리는 공간
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

    </v-col>

  

  
    <v-col
      cols="6"
      sm="4"
    >

<v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMTlfMTg1%2FMDAxNjE2MDgxNjMxOTUw.d7Og9Cih5HEhuVaVYu4Vm1G4nkRjzETfAxUK78lhhCYg.t4eQqHfHi1k0-n6uN-22XPfCfOBW_OKTj8NigcbFMeEg.JPEG.tea_n_scones%2F062719a%25A3%25ADInline.jpg&type=sc960_832"
      height="200px"
    ></v-img>

    <br>
       <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage3' }">  
     <h5> &emsp;&emsp;생일 메모</h5>
    </router-link>

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
         생일과 사진을 올리는 공간
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
    </v-col>


  
  
    <v-col
      cols="6"
      sm="4"
    >

<v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA4MDlfMjA1%2FMDAxNjI4NDk2MTY1Nzc2.kWcKSZ_7J5D7B9VJ8tX-uCqhIBCe_akbB4HDVccSqmcg.ei4ep-7vQ5060JFE1ojPcMy0wUe7aer2ZUgZNBy1DYQg.PNG.wrtyu0603%2F%25C1%25A6%25B8%25F1%25C0%25BB-%25C0%25D4%25B7%25C2%25C7%25D8%25C1%25D6%25BC%25BC%25BF%25E4.-001_%25284%2529.png&type=sc960_832"
      height="200px"
    ></v-img>

   <br>
       <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage4' }">  
     <h5> &emsp;&emsp;사이트아이디 메모</h5>
    </router-link>

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
          사이트 아이디와 사진을 올리는 공간
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
    </v-col>
</v-row>






      <v-footer app color="#FFFBE6" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>

</div>
</div>
</template>


<script>
  export default {
    data: () => ({
      show: false,
       drawer: false,
      group: null
    }),
             
    watch: {
      group () {
        this.drawer = false
      },
    },
  }
</script>