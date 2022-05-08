<template>
    <div style="font-size: 14px;">
        <div style="color: gray; font-weight: bold; padding-bottom: 8px">회원님을 위한 추천</div>
        <!-- <v-col style="height: 320px; text-align: center;" v-if="!members || (Array.isArray(members) && members.length === 0)">
                현재 등록된 게시물이 없습니다!
        </v-col> -->
        <div v-for="member in members" :key="member.memberNo" cols="4">
            <div v-if="member.memberNo!=loginInfo.memberNo" style="display: flex; padding: 8px 5px">
                <div>
                    <td style="padding-top: 3px">
                        <div style="border-radius: 70%; overflow: hidden; width: 32px ">
                            <v-img v-if="member.imageName" width="32" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                            <v-img v-else width="32" src="@/assets/profile.jpg"/>
                        </div>
                    </td>
                </div>
                <div>
                    <td align="left" style="width: 110px; padding-left: 12px; line-height: 19px">
                        <router-link style="text-decoration: none; color: black" :to="{
                            name: 'MyProfilePage',
                            params: {memberNo: member.memberNo.toString()}}">
                                <b>{{ member.memberId }}</b>
                        </router-link>
                        <div style="color: gray">{{ member.memberName }}</div>
                    </td>
                    
                </div>
                <div>
                    <td align="right" width= "100" style="padding-top: 0px">
                        <recommend-button :myFollows="myFollows" :member="member" @click="onFollow" />
                    </td>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
import RecommendButton from '@/components/likes/RecommendButton.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
  components: { RecommendButton },
    name: 'RecommendList',
    props: {
        members: {
            type: Array
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
        }
    },
    computed: {
        ...mapState(['myFollows']),
    },
    mounted () {
        this.fetchMyFollowList(this.loginInfo.memberNo)
    },
    methods: {
        ...mapActions(['fetchMyFollowList']),
        onFollow(payload) {
            const { memberNo} = payload
            axios.post(`http://localhost:7777/follow/${this.loginInfo.memberNo}/${memberNo}`, {loginNo: this.loginInfo.memberNo, memberNo})
                .then(() => {
                    // history.go(0);
                    
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        },
    }
}
</script>