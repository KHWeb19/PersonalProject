
<template>
<v-container>
  <div>
        <header-view></header-view>
        <home-banner></home-banner>
        <br>
        <home-sell-list></home-sell-list>
        <br>
        <home-brand-check-list></home-brand-check-list>
        <br>
        <home-question-board/>
  </div>
</v-container>
</template>

<script>
import HeaderView from '../../components/home/headerView.vue'
import HomeBanner from '../../components/home/HomeBanner.vue'
import HomeSellList from '../../components/home/HomeSellList.vue'
import HomeBrandCheckList from '../../components/home/HomeBrandCheckList.vue'
import HomeQuestionBoard from '../../components/home/HomeQuestionboard.vue'
//import { mapState, mapActions } from 'vuex'

  export default {
    name: 'HomeView',

    components: {
        HeaderView,
        HomeBanner,
        HomeSellList,
        HomeBrandCheckList,
        HomeQuestionBoard,
    },
  /*   computed: {
        ...mapState(['QuestionBoards'])
    },
    mounted () {
        this.fetchQuestionBoards()
    },
    methods: {
        ...mapActions(['fetchQuestionBoards'])
    }*/

  }
</script>
