<template>
  <div>
    <v-container style="font-size: 14px">
        <v-flex>
            <v-row>

                <v-col style="height: 320px; text-align: center;" v-if="!myFollows || (Array.isArray(myFollows) && myFollows.length === 0)">
                팔로우한 회원이 없습니다!

                </v-col>
                <v-col v-else v-for="myFollow in myFollows" :key="myFollow.no"  cols="4">
                    <router-link style="text-decoration: none; color: black" :to="{
                            name: 'MyProfilePage',
                            params: {memberNo: myFollow.your.memberNo.toString()}}">
                        <div style="display: flex; padding: 3px 0px">
                            <div>
                                <td style="padding: 10px 5px 0px 15px">
                                    <div style="border-radius: 70%; overflow: hidden; width: 44px ">
                                        <v-img v-if="myFollow.your.imageName" width="44" :src="require(`@/assets/mImage/${myFollow.your.imageName}`)"/>
                                        <v-img v-else width="44" src="@/assets/profile.jpg"/>
                                    </div>
                                </td>
                            </div>
                            <div>
                                <td align="left" style="width: 400px; padding: 8px">
                                    <b>{{ myFollow.your.memberId }}</b><br/>{{ myFollow.your.memberName }}
                                </td>
                            </div>
                        </div>
                    </router-link>
                </v-col>
            </v-row>
        </v-flex>
    </v-container>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
export default {
    name: 'MyFollowList',
    prop: {
        member: {
            type: Object,
            require:true
        },
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },
    computed: {
    ...mapState(['myFollows']),
    },
    created() {
        this.fetchMyFollowList(this.loginInfo.memberNo)
        .catch(()=>{
            alert('팔로우 정보 요청 실패')
            this.$router.push()
        })
    },
    mounted () {
        this.fetchMyFollowList(this.loginInfo.memberNo)

    },
    methods: {
        ...mapActions(['fetchMyFollowList']),
    }
}
</script>