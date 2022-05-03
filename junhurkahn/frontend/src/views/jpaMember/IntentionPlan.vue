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
      cols="3"
      sm="6"
    >

    
     <v-img
  lazy-src="https://picsum.photos/id/11/10/6"
  max-height="500"
  max-width="1000"
  src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA2MTdfMjcy%2FMDAxNTYwNzM5NzUxNTMw.bDOFEJyLHg69SKMoFJNYv62ChN7pHg6yivNolBb9xKgg.TQ3i-h8GlaYhqtbSp_vN_F18QiFPUaGQ4J01ACyQOGYg.JPEG.sundesign5482%2F5.jpg&type=sc960_832"
>  </v-img>
        <div class="fill-height bottom-gradient"></div>
</v-col>
  
    
    <v-col
      cols="6"
      sm="4"
    >
    <ul>
    <br>
  <font size=5> 사람들이 요즘 메모를 하지 않는 다고 한다 하지만 메모는 굉장히 중요한 하나의 습관이다 </font>
<br>
<br>
 <font size=5>사람은 하루에도 수천 가지 수만 가지의 생각을 무의식적으로 한다고 한다  </font>

<br>
<br>
<font size=5> 그렇다면 그것을 메모로 남기는 일은 그것을 인지하고 실행하다 보면 계획이 되고 그걸 반복하면 </font>
<br>
<br>

<font size=5> 시간과 인생을 계획적으로 살아가는 사람이 될 것이다. 그것을 실행하기 위해 간단하게 사용 할수 있는 개인 메모장을 만들게 되었다.</font>
<br>
<br>
    </ul>
    
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
