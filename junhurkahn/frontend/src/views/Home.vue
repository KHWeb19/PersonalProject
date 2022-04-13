<template>
  <DaumNewsCrawlerPage>
    <template #menubar>
       <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
      <h3>&nbsp;&nbsp;&nbsp;&nbsp;로그인&nbsp;&nbsp;&nbsp;&nbsp;</h3>
    </router-link>
       <router-link style="text-decoration: none;" :to="{ name: 'VuetifyMemberJoinColumnTestPage' }">
      <h3>&nbsp;회원가입&nbsp;</h3>
    </router-link>
    </template>
    <template #content>
    <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20150702_242%2Fmie5125_1435844941413HOaHB_PNG%2Funnamed.png&type=sc960_832" width = 5%> 
     <h1><b>SmartNote</b></h1>
    
    
  
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
            
           </tr>
          </thead>
          <tbody>
            <tr v-for="(list, index) of crawlLists" :key="index">
              <td style="color: gray">{{ list.newsNo }}</td>
              <td>{{ list.title }}</td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </DaumNewsCrawlerPage>
</template>

<script>

import DaumNewsCrawlerPage from '@/views/crawl/DaumNewsCrawlerPage'
import { mapState } from 'vuex'

export default {
  name: "Home.vue",
  components: {
    DaumNewsCrawlerPage
  },
  computed: {
    ...mapState({ crawlLists: state => state.crawlLists })
  },
  methods: {
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  }
}
</script>

<style scoped>


h3{color: white;}

</style>

