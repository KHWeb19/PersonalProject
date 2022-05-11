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

 <v-row>

<v-col
      cols="4"
      sm="7"
    >
     
      <v-img
  lazy-src="https://picsum.photos/id/11/10/6"
  max-height="900"
  max-width="1000"
  src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDNfMTYy%2FMDAxNjQ4OTg5NjY0MDU3.BonsM_0cJlr-YbAnACMLNNCReFIlgOwYZbuWNAD4Rpcg.s9LddKP0NiBqYWPZ7FJklUILetjTMUuJO7E-1T6NHxEg.JPEG.cuddlyidiots%2FCUDI_%25C6%25F9%25B9%25E8%25B0%25E6%25C8%25AD%25B8%25E9_%25A3%25AD_2.jpg&type=sc960_832"
> 
      </v-img>

</v-col>
  
    
     <v-col
      cols="6"
      sm="4"
    >
    <ul>
    <br>
     <br>
      <br>
  <font size=5> 4.1 ~ 4.3 메인화면(FRONTEND) </font>
<br>
<br>
 <font size=5>4.4 ~ 4.5 로그인 회원가입(FROTEND)   </font>

<br>
<br>
<font size=5> 4.6 ~ 4.7 로그인 회원가입(BACKEND) </font>
<br>
<br>

<font size=5> 4.11 ~ 4.12 텍스트 메모 계시판(FROTNEND,BACKEND)</font>
<br>
<br>

<font size=5> 4.13 ~ 4.14 계좌번호 계시판(FROTNEND,BACKEND)</font>
<br>
<br>

<font size=5> 4.15 장보기 계시판(FROTNEND,BACKEND)</font>
<br>
<br>

<font size=5> 4.19 생일관리 계시판(FROTNEND,BACKEND)</font>
<br>
<br>

<font size=5> 4.20 사이트아이디 계시판(FROTNEND,BACKEND)</font>
<br>
<br>

<font size=5> 4.21 ~ 4.22  부가기능 추가(FROTNEND,BACKEND)</font>
<br>
<br>

<font size=5> 4.25 ~ 4.27  UL수정 작업(FROTNEND)</font>
<br>
<br>





    </ul>
    
    </v-col>
    <br>
 
<br>
  
    
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
    data: () => ({
      drawer: false,
      group: null,
    }),
       
      
    watch: {
      group () {
        this.drawer = false
      },
    },
  }
    
  
</script>

<style>
/* Helper classes */

h5{color: green;}

.basil {
  background-color: #FFFBE6 !important;
}
.basil--text {
  color: #356859 !important;
}
</style>