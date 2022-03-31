<template>
    <v-container>
    <div class="my-5">
    <h2>
      인기 있는 상품
      <v-divider class="mt-2"/>

    </h2>
    </div>
      <v-row dense>
        <v-col
         cols="6"
         sm="3"
          v-for="card in cards"
          :key="card.title"
        >
          <v-card>            
          <v-img
              :src="card.src"
              class="align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="150px"
            >
    <v-chip
      class="ma-3"
      color="primary"
      label
      small

    >
      판매중
    </v-chip>
            </v-img>
                <v-card-title>
                    코스트코 빵
                </v-card-title>

                <v-card-subtitle>
                5,000원
                </v-card-subtitle>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
</template>
<script>
export default {
    name: 'popularProductList',
    data: () => ({
      cards: [
        { title: 'Pre-fab homes', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg' },
        { title: 'Favorite road trips', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg'},
        { title: 'Best airlines', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg'},
         { title: 'Best airlines', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg'},
         { title: 'Pre-fab homes', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg' },
        { title: 'Favorite road trips', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg'},
        { title: 'Best airlines', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg'},
        { title: 'Pre-fab homes', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg' },
        { title: 'Favorite road trips', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg'},
      ],
    }),
}
</script>