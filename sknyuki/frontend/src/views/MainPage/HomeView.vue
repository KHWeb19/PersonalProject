
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
        <question-board-list></question-board-list>
  </div>
</v-container>
</template>

<script>
import HeaderView from '../../components/home/headerView.vue'
import HomeBanner from '../../components/home/HomeBanner.vue'
import HomeSellList from '../../components/home/HomeSellList.vue'
import HomeBrandCheckList from '../../components/home/HomeBrandCheckList.vue'
import QuestionBoardList from '../../components/home/QuestionboardList.vue'

  export default {
    name: 'HomeView',

    components: {
        HeaderView,
        HomeBanner,
        HomeSellList,
        HomeBrandCheckList,
        QuestionBoardList,
    },
  }
</script>
