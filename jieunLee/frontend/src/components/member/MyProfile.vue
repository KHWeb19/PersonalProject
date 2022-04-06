<template>
    <div>
    <menu-bar/>
        <v-container style="max-width: 1000px; margin-top: 20px;">
        <v-flex>
            <div style="display: flex; justify-content: center;">
                <div style="width: 300px; padding-left: 75px;">
                    <v-img width="150" src="@/assets/logo.png"/>
                </div>
                <div style="width: 620px; margin-left: 20px;">
                    <div style="display: flex;">
                        <h1>{{member.memberId}}</h1> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <router-link style="text-decoration: none;" :to="{
                            name: 'AccountsEditPage',
                            params: {memberNo: member.memberNo.toString()}}">
                            <v-btn style="margin-top: 5px;" color="white">프로필 편집</v-btn>
                        </router-link>
                    </div>
                    <br/>
                    <div style="font-weight: bold">
                        {{member.memberName}}
                    </div>
                    안녕하세요 
                    <br/>
                    웹사이트주소와 소개글이 들어갈 자리
                    <br/>
                    어쩌구저쩌구 소개글입니다
                </div>
            </div>
            <br/>
            <br/>
            <v-row>
                <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
                    <v-img :src="image" aspect-ratio="1"  >
                        <template v-slot:placeholder>
                            <v-row class="fill-height ma-0" align="center" justify="center">
                                <v-progress-circular indeterminate>
                                </v-progress-circular>
                            </v-row>
                        </template>
                    </v-img>
                </v-col>
            </v-row>
        </v-flex>
        </v-container>
    </div>    
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'

export default {
    name: 'MyProfile',
    components: {
        MenuBar
    },
    props: {
      member: {
        type: Object,
        require:true
      }
    },
    data() {
        return {
            images: [
                require('@/assets/logo.png'),
                require('@/assets/vuelogo.png'),
                'https://w.namu.la/s/6d229410e3814f0113aa79f1d1ff269d0445aaa0d6dfe50223a65d5b8260cfecf5d926136fb31c18d75a2eb8b4ecccc3e6c8a5bc2a5fa9712162c9d99585db47b545c3d079fbd142bf18798129b3cb997c4cd8dcde54dc8cf7dcc802261025f6',
                'https://w7.pngwing.com/pngs/622/549/png-transparent-pokemon-black-white-pikachu-pachirisu-pokemon-minccino-pikachu.png',
                'https://w7.pngwing.com/pngs/622/549/png-transparent-pokemon-black-white-pikachu-pachirisu-pokemon-minccino-pikachu.png',
                'https://w7.pngwing.com/pngs/622/549/png-transparent-pokemon-black-white-pikachu-pachirisu-pokemon-minccino-pikachu.png',
                'https://w7.pngwing.com/pngs/622/549/png-transparent-pokemon-black-white-pikachu-pachirisu-pokemon-minccino-pikachu.png',
                'https://w7.pngwing.com/pngs/622/549/png-transparent-pokemon-black-white-pikachu-pachirisu-pokemon-minccino-pikachu.png',

            ],
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },

}
</script>

<style scoped>


.filebox input { 
  /* position: absolute; clip:rect(0,0,0,0); */
}




</style>