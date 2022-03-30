<template>
  <DaumNewsCrawlerPage>
    <template #menubar>
      <v-btn @click="start('foreign')" text color="black" style="padding: 10px; width: 90px;">로그인</v-btn>
      <v-btn @click="start('culture')" text color="black" style="padding: 10px; width: 90px;">회원가입</v-btn>
    </template>
    <template #content>
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left">No.</th>
              <th class="text-left">제목</th>
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

</style>

