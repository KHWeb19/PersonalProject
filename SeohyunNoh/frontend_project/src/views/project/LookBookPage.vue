<template>
    <div class="row text-center">
        <div class="col-md-3 col-sm-6 col-xs-12" v-for="lookbook in lookbooks" :key="lookbook">
            <v-img class="white--text align-end" :aspect-ratio="16/9" height="400px" :src="lookbook.src">
            </v-img>
            <v-card-text class="text--primary">
                {{lookbook.description}}
            </v-card-text>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
                lookbooks: [
                    {   
                        description: 'URBANIC30 2022 S/S LOOKBOOK',
                        src: 'http://www.urbanic30.com/design/urbanic30/2021/main-1.jpg',
                        route: 'https://www.urbanic30.com/board/board.html?code=urbanic30_image18&type=v&num1=999999&num2=00000&lock=N'
                    },
                    {
                        description: 'Le17Septembre 2022 S/S LOOKBOOK',
                        src: require('@/assets/img/르셉템버_2.png'),
                        route: 'https://le17septembre.com/product/detail01.html?product_no=2365&cate_no=70&display_group=1'
                    },
                    {
                        description: 'Recto 2022 S/S LOOKBOOK',
                        src: 'https://www.recto.co/img/lookbook/ss22/012.jpg',
                        route: 'https://www.recto.co/collection-women-ss22.html'
                    },
                    {
                        description: 'NothingWritten 2022 S/S LOOKBOOK',
                        src: 'https://nothing-written.com/img/22spring13.jpg',
                        route: 'https://nothing-written.com/archive-single.html?product_no=1610&cate_no=119&display_group=1'
                    }
            ]
        }
    }
}
</script>