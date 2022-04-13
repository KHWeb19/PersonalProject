<template>
    <div>
        <!-- 메인페이지 이미지슬라이드 너비가 꽉 차게 하고싶은데 안됨-->
        <!-- <div id="app">
            <v-app id="inspire">
                <v-continer fluid ma-0 pa-0 fill-height>
                    <v-row >
                        <v-col>
                            <v-carousel cycle hide-delimiters  height="auto">
                                <v-carousel-item v-for="(banner,i) in banners" :key="i">
                                     <v-img :src="banner.src" block width="100%" height="100%" object-fit: cover></v-img>
                                </v-carousel-item>
                            </v-carousel>
                        </v-col>
                    </v-row>
                </v-continer>
            </v-app>
        </div> -->

        <!-- 이미지 슬라이드 --> 
          <v-carousel hide-delimiters>
            <v-carousel-item
                :src="'http://img.ouimerci.co.kr/2021_re/21ss/a1.jpg'"
                :to="{ path: '/lookBookPage'}"
            >
                <v-row
                class="fill-height"
                align="center"
                justify="center"
                >
                <div class="display-2 white--text pl-5 pr-5 hidden-sm-only"><strong>2022 S/S OPEN</strong></div><br/>
                </v-row>
            </v-carousel-item>
            <v-carousel-item
                :src="require('@/assets/img/르셉템버_2.png')"
                :to="{ path: '/lookBookPage'}"
            >
                <v-row
                class="fill-height"
                align="center"
                justify="center"
                >
                <div class="display-2 white--text pl-5 pr-5 hidden-sm-only"><strong>2022 S/S OPEN</strong></div><br/>
                </v-row>
            </v-carousel-item>
            <v-carousel-item
                :src="'https://www.recto.co/img/lookbook/ss22/043.jpg'"
                :to="{ path: '/lookBookPage'}"
            >
                <v-row
                class="fill-height"
                align="center"
                justify="center"
                >
                <div class="display-2 white--text pl-5 pr-5 hidden-sm-only"><strong>2022 S/S OPEN</strong></div><br/>
                </v-row>
            </v-carousel-item>
            <v-carousel-item
                :src="'https://nothing-written.com/web/product/extra/small/202103/a9270fa7b945cda8fb6a03be7b1442f7.jpg'"
                :to="{ path: '/lookBookPage'}"
            >
                <v-row
                class="fill-height"
                align="center"
                justify="center"
                >
                <div class="display-2 white--text pl-5 pr-5 hidden-sm-only"><strong>2022 S/S OPEN</strong></div><br/>
                </v-row>
            </v-carousel-item>
        </v-carousel>

        <!-- SHOP NOW! NEW ARRIVALS! --> 
        <div class="pl-4 pr-4 row">
            <div
            class="col-md-6 col-sm-6 col-xs-12"
            >
                <v-card>

                <v-img
                    :src="require('@/assets/img/얼바닉30_1.jpg')"
                    class="white--text align-center"
                    gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                    height="400px"
                >
                <h1 class="text-center font-size">Top Picks</h1>
                    <div class="text-center">
                    <v-btn  href="/womenOuterCategory" class="white--text " outlined>SHOP NOW</v-btn>
                    </div>
                </v-img>
                </v-card>
            </div>
            <div
                class="col-md-6 col-sm-6 col-xs-12"
            >
                <v-card>
                <v-img
                    :src="require('@/assets/img/르셉템버_1.png')"
                    class="white--text align-center"
                    gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                    height="400px"
                >
                    <h1 class="text-center font-size">New Arrivals</h1>
                    <div class="text-center">
                    <v-btn  href="/womenOuterCategory" class="white--text" outlined>SHOP NOW</v-btn>
                    </div>
                </v-img>
                </v-card>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: 'MainPage.vue',
    components: {
        
    },
    data() {
        return {
            
            }
        }
    }
</script>

<style scoped>
.v-card--reveal {
    align-items: center;
    bottom: 0;
    justify-content: center;
    opacity: .5;
    position: absolute;
    width: 100%;
  }
</style>