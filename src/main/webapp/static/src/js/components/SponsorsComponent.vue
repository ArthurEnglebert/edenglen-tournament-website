<template>
    <slick ref="slick" :options="slickOptions" :class="{footer__slider: true}">
        <div v-for="(slide, index) in slides" :class="{footer__slide: true}">
            <a :href="slide.link" v-if="slide.link" target="_blank" rel="noreferrer nofollow">
                <img :src="slide.img" :alt="'sponsor-' + (index + 1)"/>
            </a>


           <img :src="slide.img" :alt="'sponsor-' + (index + 1)" v-else />
        </div>
    </slick>
</template>

<script>
    import Slick from 'vue-slick';

    export default {
        components: { Slick },

        data() {
            return {
                slickOptions: {
                    slidesToShow: 4,
                    dots: false,
                    arrows: false,
                    autoplay: true,
                    autoplaySpeed: 1000,
                    speed: 1000
                },
                slides: [
                    {img: '/static/dist/assets/img/sponsors/puilaetcodewaay.jpg', link: 'https://www.puilaetcodewaay.be/fr'},
                    {img: '/static/dist/assets/img/sponsors/puilaetcodewaay.jpg', link: 'https://www.puilaetcodewaay.be/fr'},
                ]
            };
        },

        created() {

        },

        watch: {
            slides: function (newSlides) {
                let currIndex = this.$refs.slick.currentSlide()

                this.$refs.slick.destroy()

                this.$nextTick(() => {
                    this.$refs.slick.create()
                    this.$refs.slick.goTo(currIndex, true)
                })
            }
        },
    }
</script>