<template>
    <v-container class="title">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/myWithTItle.png" width=250 >
        </v-row>
        <br/>
        <v-divider/>
        <br/>
        <v-row>
            <my-with-info :memberStudies="memberStudies" />
        </v-row>
    </v-container>
</template>

<script>
import MyWithInfo from '@/components/form/MyWithInfo.vue'
import { mapActions, mapState } from 'vuex'
export default {
  components: { MyWithInfo },
    name:'MyWith',
    computed: {
        ...mapState(['memberStudies'])
    },
    created () {
        this.memberNo = this.$store.state.userInfo.memberNo
    },
    mounted () {
        this.fetchMemberStudyList(this.memberNo)
    },
    methods: {
        ...mapActions(['fetchMemberStudyList'])
    }
  }
</script>

<style scoped>
.title {
    margin-top:3%;
}
.titleImg {
    margin-bottom:20px;
}

</style>