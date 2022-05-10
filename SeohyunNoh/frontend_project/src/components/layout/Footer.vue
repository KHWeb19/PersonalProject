<template>
    <footer>
          <v-card flat tile class="basil basil--text text-center">
            <v-card-text>
            <v-btn v-for="icon in icons" :key="icon" class="mx-4 basil--text" icon>
                <v-icon size="24px">
                {{ icon }}
                </v-icon>
            </v-btn>
            </v-card-text>
    
            <v-card-text class="basil--text pt-0">
            상호명: 주식회사 SELECTSHOP (SELECTSHOP Co., Ltd.) 사업장소재지: 서울특별시 강남구
            <br/> 
            전화번호: 1234-5678 이메일: pesonalProject@selectshop.co.kr 대표: 노서현
            </v-card-text>
    
            <v-divider></v-divider>
    
            <v-card-text class="basil--text">
            {{ new Date().getFullYear() }} — <strong>SELECTSHOP</strong>
            </v-card-text>
      </v-card>
    </footer>
</template>

<script>
    export default {
        data() {
            return{
                 icons: [
                    'mdi-facebook',
                    'mdi-twitter',
                    'mdi-linkedin',
                    'mdi-instagram',
                ]
            }
            
        }
    }
</script>

<style>
footer {
        margin-top: 100px;
        /* background-color: darkgrey;
        background-color: rgba(0,0,0,0.3); */
        font-size: 10px;
    }
</style>