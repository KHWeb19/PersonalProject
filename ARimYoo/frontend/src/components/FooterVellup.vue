<template>
    <v-container>
        <v-footer dark padless style="margin-left:auto; margin-right:auto">
        <v-card
        flat
        tile
        class="white--text text-center flex"
        >
        <v-card-text  class="white--text">
            <strong>Vellup!</strong>&nbsp; —  &nbsp; Level up Your Develop Skill
        </v-card-text>
        <v-card-text>
        <v-btn
            v-for="icon in icons"
            :key="icon"
            class="mx-4"
            dark
            small
            icon
            >
            <v-icon size="24px">
                {{ icon }}
            </v-icon>
            </v-btn>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text" style="font-size:10pt">
            Copyright © {{ new Date().getFullYear() }}  Yoo A Rim All Right Reserved
        </v-card-text>
        </v-card>
    </v-footer>
    </v-container>
</template>
<script>
export default {
    name:'FooterVellup',
    data () {
        return {
             icons: [
        'mdi-facebook',
        'mdi-twitter',
        'mdi-linkedin',
        'mdi-instagram',
      ],
        }
    }
}
</script>

<style scoped>
.v-footer{
    font-family: 'Noto Sans KR', sans-serif;
}
</style>