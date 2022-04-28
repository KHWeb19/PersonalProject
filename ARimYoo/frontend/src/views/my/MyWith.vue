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
        <v-row>
            <my-project-info :memberProjects="memberProjects"/>
        </v-row>
    </v-container>
</template>

<script>
import MyWithInfo from '@/components/my/MyStudyInfo.vue'
import { mapActions, mapState } from 'vuex'
import MyProjectInfo from '@/components/my/MyProjectInfo.vue'
export default {
  components: { MyWithInfo, MyProjectInfo },
    name:'MyWith',
    computed: {
        ...mapState(['memberStudies', 'memberProjects'])
    },
    created () {
        this.memberNo = this.$store.state.userInfo.memberNo
    },
    mounted () {
        this.fetchMemberStudyList(this.memberNo)
        this.fetchMemberProjectList(this.memberNo)
    },
    methods: {
        ...mapActions(['fetchMemberStudyList', 'fetchMemberProjectList'])
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