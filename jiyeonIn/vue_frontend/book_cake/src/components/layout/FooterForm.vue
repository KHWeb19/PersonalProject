<template>
    <v-footer dark="dark" padless="padless">
        <v-card
            flat="flat"
            title="title"
            class="pink accent-1 text-center"
            width="100%">
        

            <v-card-text >
                <v-btn v-for="icon in icons" :key="icon" class="mx-4" icon="icon">
                    <v-icon size="24px">{{ icon }}</v-icon>
                </v-btn>
            </v-card-text>

            <v-card-text class="pt-0">
                INDICAKE | 대표 : 인지연 | 소재지: 인천광역시 연수구 송도과학로 16번길 33<br>
                Copyright© 2021 LifeOfMoment. All Right Reserved.
            </v-card-text>

            <v-divider></v-divider>

        </v-card>
    </v-footer>
</template>

<script>
    export default {
        name: 'FooterForm',
        data: () => ({
            icons: [
            'mdi-facebook',
            'mdi-twitter',
            'mdi-linkedin',
            'mdi-instagram',
            ],
        }),
    };
</script>

<style scoped>

</style>