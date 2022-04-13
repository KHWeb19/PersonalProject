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