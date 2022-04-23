<template>
  <div class="app">
    <router-link style="text-decoration: none;" :to="{ name: 'Home' }">
       &nbsp;Home&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'VueFileUploadPage' }">
        &nbsp;File Upload Test&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'VuetifyMemberRegisterPage' }">
      &nbsp;Vuetify Member Register Test&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'VuetifyMemberJoinColumnTestPage' }">
      &nbsp;Vuetify Member Join Column Test&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
      &nbsp;Login Test&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage' }">
      &nbsp;Jpa Board List&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'JpaMemberAuthTestPage' }">
      &nbsp;Business Member Check&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'DaumNewsCrawlerPage' }">
      &nbsp;다음 뉴스 크롤링
    </router-link>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
  }
}

</script>
