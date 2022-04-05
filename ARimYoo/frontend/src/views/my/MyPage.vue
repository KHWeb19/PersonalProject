<template>
    <v-container class="title">
        <v-row justify="center">
            <img class="align-center" src="@/assets/title/MyPageTitle.png" width=250 >
        </v-row>
        <br/>
        <v-divider/>
        <br/>
        <v-row>
            <member-info :userInfo="userInfo"/>
        </v-row>
    </v-container>
</template>

<script>
import MemberInfo from '@/components/form/MemberInfo.vue'
import { mapActions, mapState } from 'vuex'

export default  {
    name:'MyPage',
    components: {
        MemberInfo
    },
     computed: {
        ...mapState(['userInfo'])
    },
    created() {
        this.fetchMember(this.$store.state.userInfo.memberNo)
        .catch(() => {
            alert ('유저정보 불러오기 실패 !')
        })
    },
   
    methods: {
        ...mapActions(['fetchMember'])
    }
}
</script>

<style scoped>
.title {
    margin-top:3%;
}
</style>